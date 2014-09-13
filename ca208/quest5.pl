bouncer :-
	write('whats your age?'),
	read(X),
	nl,
	anwser(X).
	
anwser(X) :- 
	(X > 20),
	write('in you go').
anwser(X) :-
	(X > 17),
	write('regulars only').
anwser(X) :-
	write('no kids').
