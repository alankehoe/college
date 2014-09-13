#Basic SIR program without Deaths/Births, written in python.

# S = Susceptable
# I = Infected 
# R = Recovered 
# Once a person has recovered, they can no longer be re-infected

# Our epidemic rates will stay constant - Monte Carlo!

# Given this, our equations will be straightforward 
# Suceptable/time = -Tranmission Rate * Initail Susceptable number of people * Inital Infected 
# Infected/time = Tranmission Rate * Initail Susceptable number of people * Inital Infected - RecoveryRate * Initail infected
# Recovered/time = RecoveryRate * Initail infected

# Time scale = days 

# Imports
import scipy.integrate as sci
import numpy as np
import pylab as plt


# Set Values
# Beta = Tranmission rate 
# gamma = Recovery Rate
# TS = Time Increments
# ND = Ending Time
# S0 = Starting suceptable
# I0 = Initiatial infected 
dt=0.01;
beta=1*dt;
gamma=0.25*dt;
TS=1.0
ND=3000
S0=1-1e-6
I0=1e-6
INPUT = (S0, I0, 0.0)


def epidemic(INP,t):  
	'''The main set of equations'''
	Temp=np.zeros((3))
	Vector = INP    

	# Suceptable/time = -Tranmission Rate * Initail Susceptable number of people * Inital Infected 
	Temp[0] = - beta * Vector[0] * Vector[1]

	# Infected/time = Tranmission Rate * Initail Susceptable number of people * Inital Infected - RecoveryRate * Initail infected
	Temp[1] = beta * Vector[0] * Vector[1] - gamma * Vector[1]

	# Recovered/time = RecoveryRate * Initail infected
	Temp[2] = gamma * Vector[1]


	return Temp   # For odeint
	# Odeint = Integrate a system of ordinary differential equations.


t_start = 0.0; t_end = ND; t_inc = TS
t_range = np.arange(t_start, t_end+t_inc, t_inc)
RES = sci.odeint(epidemic,INPUT,t_range) 

# print RES - For error testing 

#Ploting
plt.plot(RES[:,0], '-b', label='Susceptibles')
plt.plot(RES[:,2], '-g', label='Recovereds')
plt.plot(RES[:,1],  '-r', label='Infectious')
plt.legend(loc=0)
plt.title('SIR_MonteCarlo.py')
plt.xlabel('Time')
plt.ylabel('Susceptibles, Infected And Recovereds')
plt.show()