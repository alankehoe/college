##########################################################
# Starting script to the module 'SIR models of epidemics'
##########################################################

# implements the basic SIR model, and plots simulation results

## Here you only need to know basic things:
##  #	To make comments
##  <-	Assigning a value to a symbol
##  c	To create a vector c(v1, v2, ..., vn)
##  e	is *10^
##  seq(a,b,c)	To create a sequence from a to b with intervals c


###################################
# FUNCTION DEFINITIONS
###################################

###
# SIR <- function(t, x, parms)
# Use: calculates the derivatives for the SIR model
# Input: 
#      t: time (not used here, because there is no explicit time dependence)
#      x: vector of the current values of all variables (S, I, R)
#      parms: vector of all parameter values
# Output:
#      der: vector of derivatives

# To use the lsoda function, the model function has to be a function of t (time),
# x (the vector of the variables) and parms (the parameters of the model).

SIS <- function(t, x, parms){

# Beta and r are not global variables. This means that if you type beta in R, the output will be 'beta',
# and not its value. You have to specify that you want to use the value of beta from 'parms' to solve the ODEs.
# Similarly, the variables of the model are taken from the vector x. This is done by the 'with' function.

  with(as.list(c(parms,x)),{
    dS <- - beta*S*I
    dI <- + beta*S*I 
    der <- c(dS, dI)
    list(der)  # the output must be returned    
  }) # end of 'with'

}  # end of function definition


###########################
# MAIN PROGRAM
###########################

### LOAD LIBRARIES
#load R library for ordinary differential equation solvers
library(deSolve)

### INITIALIZE PARAMETER SETTINGS

parms <- c(beta=1e-3)		# set the parameters of the model
inits <- c(S=499, I=1)		# set the initial values
dt    <- seq(0,100)			# set the time points for evaluation

# Calculate and print R_0 on the screen
# R_0 = Basic reproductive rate 
N <- sum(inits)
R_0 <- with(as.list(parms),{beta*N})
print(paste("R_0 =",R_0),quote=FALSE)


### SIMULATE THE MODEL

## Use lsoda to solve the differential equations numerically. The syntax should be
## lsoda(initial values, time points, function, parameters)

simulation <- as.data.frame(lsoda(inits, dt, SIS, parms=parms)) # this way our set 'parms' will be used as default

### PLOT THE OUTPUT
# Plot S according to time, in blue, and add the graph I and R according to time,
# in red and dark green respectively. Call help(plot) for further details.

attach(simulation) # this command allows you to refer to the columns of the data frame directly.

plot(dt, S, type="l", col="blue", ylim=c(0,sum(inits)), xlab="time", ylab="number of individuals")
lines(dt, I, type="l", col="red")

# Add a legend to the graph
legend(70,400, legend=c("S","I"), col=c("blue", "red"), lty=rep(1,3))
#dev.off()

detach(simulation) # clean up the search pathS