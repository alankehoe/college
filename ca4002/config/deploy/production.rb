set :stage, :production

server 'alan@app.raven.com',
       user: 'alan',
       roles: %w{web app db},
       ssh_options: {
           user: 'alan',
           forward_agent: true,
           keys: %w(~/.ssh/id_rsa),
           auth_methods: %w(publickey)
       }