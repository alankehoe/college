hello :- write('please enter your name '), 
	read(Name), 
	nl, 
	write('Hello '), 
	write(Name),
	nl.

first_term(File) :-
	see(File), 
	read(Term), 
	write(Term), 
	nl, 
	seen.
