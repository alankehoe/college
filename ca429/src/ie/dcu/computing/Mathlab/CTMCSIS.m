% CTMC SIS Epidemic Model
% Three Sample Paths and the Deterministic Solution
clear
set(0,'DefaultAxesFontSize', 18);
set(gca,'fontsize',18);
beta=1;
b=0.25;
g=0.25;
R0=beta/(b+g);
N=100;
init=2;
time=25;
sim=3;



for k=1:sim
clear t s i
t(1)=0;
i(1)=init;
j=1;
while i(j)>0 && t(j)<time
u1=rand; % uniform random number
u2=rand; % uniform random number
tot=(beta/N)*i(j)*(N-i(j))+(b+g)*i(j);
birth=(beta*(N-i(j))/N)/(beta*(N-i(j))/N+b+g);
t(j+1)=t(j)-log(u1)/tot;
if u2 <= birth
i(j+1)=i(j)+1;
else
i(j+1)=i(j)-1;
end

j=j+1;
end

if k==1
stairs(t,i,'r-','LineWidth',2)
elseif k==2
stairs(t,i,'b-','LineWidth',2)
else
stairs(t,i,'g-','LineWidth',2)
end
hold on
end

% Euler�s Method Applied to the Deterministic SIS Epidemic Model
dt=0.01;
y(1)=init;
for k=1:time/dt
y(k+1)=y(k)+dt*(beta*(N-y(k))*y(k)/N-(b+g)*y(k));
end


plot([0:dt:time],y,'k--','LineWidth',2);
axis([0,time,0,80]);
xlabel('Time');
ylabel('Number of Infectives');
hold off