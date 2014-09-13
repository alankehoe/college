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
beta=.5
gamma=0.1
TS=1.0
ND=70
S0=1-1e-6
I0=1e-6
mu=0.016
INPUT = (S0, I0, 0.0)


def epidemic(INP,t):  
	'''The main set of equations for our epidemic(SIR-Vaccination)'''
	Temp=np.zeros((3))
	Vector = INP    

	# Develope constant = Suceptable + Infected + Recovered 
	N = Vector[0] + Vector[1] + Vector[2]


	# Suceptable/time = -Tranmission Rate * (Initail Susceptable number of people * Inital Infected)/Constant - vaccination rate * Initial Suceptable 
	Temp[0] = - beta * (Vector[0] * Vector[1])/N - mu * Vector[0] 

	# Suceptable/time = Tranmission Rate * (Initail Susceptable number of people * Inital Infected)/Constant - Recovery rate * Initial Infected 
	Temp[1] = beta * (Vector[0] * Vector[1])/N - gamma * Vector[1]

	# Recovered/time = RecoveryRate * Initail infected + Vaccintation Rate * Initial Suceptable 
	Temp[2] = gamma * Vector[1] + mu * Vector[0]


	return Temp


t_start = 0.0; t_end = ND; t_inc = TS
t_range = np.arange(t_start, t_end+t_inc, t_inc)
RES = sci.odeint(diff_eqs,INPUT,t_range) 

# print RES - For error testing 

#Ploting
plt.plot(RES[:,0], '-bs', label='Susceptibles')
plt.plot(RES[:,2], '-g^', label='Recovereds')
plt.plot(RES[:,1],  '-ro', label='Infectious')
# plt.plot(RES[:,3],  '--r', label='Infectious')
plt.legend(loc=0)
plt.title('SIR_MonteCarlo(VACCINATION).py')
plt.xlabel('Time')
plt.ylabel('Susceptibles, Infected And Recovereds')
plt.show()