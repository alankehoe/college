%Stochastic SIR Model with Drug Resistance

%Length of infectivity 1/g=4 days
%Rate of conversion of nonresistant to resistant k=.005
%Population size is 1000. Time is 120 days or 4 months

clear all

N=100; 
g=0.25; 
k=0.005;
time=100; 
dt=0.05; 
tim=time/dt; 
sim=100;
R0=2;

beta=R0*(g);
betar=beta; % Transmission of Resistant Strains=NonResistant
%Choose the effectiveness of treatment on
%reduction of transmission: p

p=0.7;


%Choose effectiveness of treatment on
%reduction of length of infectivity by a factor f: f/g
f=0.6;
r=1/f;


%Calculation of R0 and RT
R0=beta/g
RT=max(p*beta/(r*g+k),betar/g)
%Choose initial number of treated that are infected.
%Number of resistant cases are set to zero.


InitailInfected=2;

InitailInfected=round(InitailInfected);
S(1)=N-InitailInfected; InfectedTreated(1)=InitailInfected; InfectedTreatedDrugRes(1)=0;
ResFreq=InitailInfected; NonResFreq=0;


for t=1:tim
% Euler�s Method Applied to the SIR Epidemic Model
Freq1=-(p*beta*InfectedTreated(t)+betar*InfectedTreatedDrugRes(t))*Spr(t)/N;
Freq2=(p*beta*InfectedTreated(t))*Spr(t)/N-(r*g+k)*InfectedTreated(t);
Freq3=(betar*InfectedTreatedDrugRes(t))*Spr(t)/N-g*InfectedTreatedDrugRes(t)+k*InfectedTreated(t);
ResFreq=ResFreq+dt*(p*beta*InfectedTreated(t)*Spr(t)/N);
NonResFreq=NonResFreq+dt*(betar*InfectedTreatedDrugRes(t)*Spr(t)/N+k*InfectedTreated(t));
Spr(t+1)=Spr(t)+dt*Freq1;
InfectedTreated(t+1)=InfectedTreated(t)+dt*Freq2;
InfectedTreatedDrugRes(t+1)=InfectedTreatedDrugRes(t)+dt*Freq3;
end

TotalResist_ODE=round(NonResFreq) %Total Resistant Cases (ODE)
TotalNonResist_ODE=round(ResFreq) % Total NonResistant Cases (ODE)
set(0,'DefaultAxesFontSize', 16); set(gca,'fontsize',16);
plot([0:dt:time],InfectedTreated,'g-',[0:dt:time],InfectedTreatedDrugRes,'r-','linewidth',2);
legend('NonResistant Cases','Drug Resistant Cases');
xlabel('Days'); ylabel('Number of Cases');
hold on


scountitr=InitailInfected; scountirtr=0.;
j=1;
spr(1)=N-InitailInfected; itr(1)=InitailInfected; irtr(1)=0; tt(1)=0;

while tt(j)<time & itr(j)+irtr(j)>0.5; % One Sample Path
u1=rand;
u2=rand;
ev1=p*beta*itr(j)*spr(j)/N;
ev2=betar*irtr(j)*spr(j)/N;
ev3=r*g*itr(j);
ev4=g*irtr(j);
ev5=k*itr(j);
prob1=ev1;
prob2=prob1+ev2;
prob3=prob2+ev3;
prob4=prob3+ev4;
tot=prob4+ev5;
tt(j+1)=tt(j)-log(u1)/tot;
if u2<=prob1/tot;
spr(j+1)=spr(j)-1;
itr(j+1)=itr(j)+1;
irtr(j+1)=irtr(j);
scountitr=scountitr+1;
elseif u2>prob1/tot & u2<=prob2/tot;
spr(j+1)=spr(j)-1;
itr(j+1)=itr(j);
irtr(j+1)=irtr(j)+1;
scountirtr=scountirtr+1;
elseif u2> prob2/tot & u2<=prob3/tot;
spr(j+1)=spr(j);
itr(j+1)=itr(j)-1;
irtr(j+1)=irtr(j);
elseif u2>prob3/tot & u2<=prob4/tot;
spr(j+1)=spr(j);
itr(j+1)=itr(j);
irtr(j+1)=irtr(j)-1;
else
spr(j+1)=spr(j);
itr(j+1)=itr(j)-1;
irtr(j+1)=irtr(j)+1;
scountirtr=scountirtr+1;
end
j=j+1;
end

plot(tt,itr,'g--',tt,irtr,'r--','linewidth',2);
hold off
TotalResist_CTMC=scountirtr %Total Resistant Cases (One Sample Path)
TotalNonResist_CTMC=scountitr %Total NonResistant Cases (One Sample Path)
Resist=0;

for jj=1:sim; % 1000 Sample paths
clear tt spr itr irtr
j=1;
scountitr=InitailInfected;scountirtr=0;
spr(1)=N-InitailInfected; itr(1)=InitailInfected; irtr(1)=0; tt(1)=0;
while tt(j)<time & itr(j)+irtr(j)>0.5;
u1=rand;
u2=rand;
ev1=p*beta*itr(j)*spr(j)/N;
ev2=betar*irtr(j)*spr(j)/N;
ev3=r*g*itr(j);
ev4=g*irtr(j);
ev5=k*itr(j);
prob1=ev1;
prob2=prob1+ev2;
prob3=prob2+ev3;
prob4=prob3+ev4;
tot=prob4+ev5;
tt(j+1)=tt(j)-log(u1)/tot;
if u2<=prob1/tot;
spr(j+1)=spr(j)-1;
itr(j+1)=itr(j)+1;
irtr(j+1)=irtr(j);
scountitr=scountitr+1;
elseif u2>prob1/tot & u2<=prob2/tot;
spr(j+1)=spr(j)-1;
itr(j+1)=itr(j);
irtr(j+1)=irtr(j)+1;
scountirtr=scountirtr+1;
elseif u2> prob2/tot & u2<=prob3/tot;
spr(j+1)=spr(j);
itr(j+1)=itr(j)-1;
irtr(j+1)=irtr(j);
elseif u2>prob3/tot & u2<=prob4/tot;
spr(j+1)=spr(j);
itr(j+1)=itr(j);
irtr(j+1)=irtr(j)-1;
else
spr(j+1)=spr(j);
itr(j+1)=itr(j)-1;
irtr(j+1)=irtr(j)+1;
scountirtr=scountirtr+1;
end
j=j+1;
end
if scountirtr>10 Resist=Resist+1; end
end

ProbResistOutbreak=Resist/sim % Probability Resistant cases >10
