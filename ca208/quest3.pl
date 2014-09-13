natoms([],0).

natoms([X|Y],Na) :-
	atom(X),
	natoms(Y,Na1),
	Na is Na1+1.

natoms([X|Y],Na) :-
	natoms(Y,Na).

nints([],0).

nints([X|Y],Na) :-
	integer(X),
	nints(Y,Na1),
	Na is Na1+1.

nints([X|Y],Na) :-
	nints(Y,Na).

atoms_and_integers(L) :-
	natoms(L,Na),write('atoms = '),write(Na),nl,
	nints(L,Ni),write('ints = '),write(Ni),nl.


largest([X],X).

largest([X,Y|Rest],L) :-
	largest([Y|Rest],L1),
	maxx(X,L1,L).

maxx(X,Y,M) :- (X > Y, M is X);(X =< Y, M is Y) .
