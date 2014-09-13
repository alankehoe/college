male(rob).
male(andy).
male(john).

female(claire).
female(mary).

parent(john,rob).
parent(john,andy).
parent(john,claire).

parent(mary,rob).
parent(mary,andy).
parent(mary,claire).


brother(X,Y) :- male(X),parent(Z,X),parent(Z,Y).
sister(X,Y) :- female(X),parent(Z,X),parent(Z,Y).
