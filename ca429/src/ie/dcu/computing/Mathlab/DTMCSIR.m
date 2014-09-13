%DTMC SIR

clear
set(0,'DefaultAxesFontSize', 18)
set (gca,'fontsize', 18)
dt=0.01;
beta=1*dt;
b=0*dt;
gam=0.25*dt;
N=100;
init=2;
time=3000;
sim=3;

for k=1:sim
clear t s i
t(1)=0;
i(1)=init;
r(1)=0;
s(1)=N-init;
j =1;
while i(j)>0&&t(j)<time
u1=rand ; % uniform random number
u2=rand ; % uniform random number
a=(beta/N)*i(j)*s(j)+gam*i(j)+b*(N-s(j));
probi=(beta*s(j)*i(j)/N)/a;
t(j+1)=t(j)+1;
if u1>a
i(j+1)= i(j);
s(j+1)=s(j);
r(j+1)= r(j);
elseif u2<=probi
i(j+1)= i(j)+1;
s(j+1)= s(j)-1;
r(j+1)= r(j);
else
i(j+1)= i(j)-1;
s(j+1)= s(j);
r(j+1)= r(j)+1;
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

% plot (t,i,'r-','LineWidth',2)
% hold on
end

% Euler ' s method applied to the deterministic SIR model.
y(1)=init; % y = i
x(1)=0; % x = r

for k =1:time/dt
x(k+1)=x(k)+dt*(gam*y(k)-b*x(k)); % R
y(k +1)=y(k)+dt*((beta*y(k)*(N-(x(k)+y(k))))/N-(b+gam)*y(k)); % I
end

plot ([0:dt:time],y,'k--','LineWidth',2);
axis ([0,time ,0 ,100]);
xlabel ('Time Steps');
ylabel ('Number of Infectives');
hold off
