require 'nokogiri'
require 'open-uri'
require 'httparty'

# TODO - Change this when deployed
BASE_API_URL = 'http://fuel.raven.com/api'
OIL_PRICE_URL = 'http://www.exchangerates.org.uk/commodities/live-oil-prices/OIL-USD.html'
START_PUMPS_URL = 'http://pumps.ie/findStationsByArea.php?county='
END_PUMPS_URL = '&zone=Select+an+area'
COUNTIES = %w(
      Dublin
)

total_petrol = 0.0
total_diesel = 0.0
total_valid_diesel_records = 0.0
total_valid_petrol_records = 0.0

# Get data from http://pumps.ie
COUNTIES.each do |county|
  pumps_page = Nokogiri::HTML(open("#{START_PUMPS_URL}#{county}#{END_PUMPS_URL}"))
  pumps_rows = pumps_page.xpath('//tr[2]/td/table/tr/td')
  results = []

  # Pull all data from pumps.ie. some is dirty so not persisting just yet.
  pumps_rows[2..-2].each_slice(6) do |a|
    record = {:fuel_record => {
        :name => a[0].text,
        :road => a[1].text,
        :area => a[2].text,
        :county => a[3].text,
        :petrol => a[4].css('table tr td').text[0..4].to_f  / 100,
        :diesel => a[5].css('table tr td').text[0..4].to_f  / 100
    }}

    results << record
  end

  # Calculate average.
  results[2..-1].each do |record|
    if record[:fuel_record][:petrol] > 1.0 && record[:fuel_record][:petrol] < 2.5
      total_petrol += record[:fuel_record][:petrol]
      total_valid_petrol_records += 1
    else
      puts 'Dirty data'
    end

    if record[:fuel_record][:diesel] > 1.0 && record[:fuel_record][:diesel] < 2.5
      total_diesel += record[:fuel_record][:diesel]
      total_valid_diesel_records += 1
    else
      puts 'Dirty data'
    end
  end
end

# Get data from http://www.eia.gov
oil_page = Nokogiri::HTML(open("#{OIL_PRICE_URL}"))
average_oil = oil_page.xpath("//td[@id='value_OILUSD']").text
average_oil = average_oil.to_f / 159 # 159 litres in a barrel of oil

# Post our averages for time of scrape.
HTTParty.post(BASE_API_URL + '/average_prices.json',
              body: {:average_values => {
                  :average_diesel => total_diesel / total_valid_diesel_records,
                  :average_petrol => total_petrol / total_valid_petrol_records,
                  :average_oil => average_oil
              }},
              :options => {
                  :headers => {
                      :ContentType => 'application/json',
                      :Accept => 'application/json'
                  }
              })

puts "Completed web scraping at #{Time.now}"
