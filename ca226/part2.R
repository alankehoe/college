button <- menu(c("Binomial","Geometric","HyperGeometric","Poisson"), graphics = TRUE, title = "Which distribution?")
if(button == 1){
	p <- winDialogString("enter probability","")
	p <- as.numeric(p)
	n <- winDialogString("enter number of trials","")
	n <- as.numeric(n)
	r <- winDialogString("enter range 0 - ?","")
	r <- as.numeric(r)
	r <- 0:r

	par(mfrow = c(2, 1))

	#pdf
	plot(r, round(dbinom(r, size = n, prob = p),2), xlab = "Number of Successes",
	ylab = "P(X = x)", type = "h", main = "Binomial PDF")

	#cdf
	plot(r, round(pbinom(r, size = n, prob = p),2), xlab = "Number of Successes",
	ylab = "P(X <= x)", ylim = c(0, 1), type = "s", main = "Binomial CDF")
}

if(button == 2){
	p <- winDialogString("enter probability","")
	p <- as.numeric(p)
	r <- winDialogString("enter range 0 - ?","")
	r <- as.numeric(r)
	r <- 0:r

	par(mfrow = c(2, 1))

	#pdf
	plot(r+1, round(dgeom(r, prob = p),2), xlab = "X = Number of Trials", ylab = "P(X=x)",
	type = "h", main = "Geometric PDF")

	#cdf
	plot(r+1, round(dgeom(r, prob = p),2), xlab = "X = Number of Trials", ylab = "P(X<=x)",
	type = "s", main = "Geometric CDF")
}

if(button == 3){
	d <- winDialogString("enter number of desired items","")
	d <- as.numeric(d)
	d <- 0:d
	n <- winDialogString("enter total number of chosen items","")
	n <- as.numeric(n)
	N <- winDialogString("enter total number of items in set","")
	N <- as.numeric(N)
	N <- N-n
	p <- winDialogString("enter number of trials","")
	p <- as.numeric(p)

	par(mfrow = c(2, 1))
	
	#pdf
	plot(d, round(dhyper(d, n, N, p),2), xlab = "Trial Number",
	type = "h", ylab = "P(X=x)", main = "HyperGeometric PDF")

	#cdf
	plot(d, round(phyper(d, n, N, p),2), xlab = "Trial Number",
	type = "s", ylab = "P(X=x)", main = "HyperGeometric CDF")
	
}

if(button == 4){
	a <- winDialogString("enter number of events","")
	a <- as.numeric(a)
	a <- 0:a
	b <- winDialogString("enter ? (average occurrence rate in the time period)","")
	b <- as.numeric(n)

	par(mfrow = c(2, 1))
	
	#pdf
	plot(a, round(dpois(a, b),2), xlab = "Number of events", ylab = "P(X=x)", 
	type = "h", main= "?(average occurrence rate in the time period)")
	
	#cdf
	plot(a, round(ppois(a, b),2), xlab = "Number of events", ylab = "P(X=x)", 
	type = "s", main= "?(average occurrence rate in the time period)")		
}
