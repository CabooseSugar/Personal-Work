sorted([]).
sorted([_]).
sorted([X,Y|Z]) :- X =< Y , sorted([Y|Z]).

subsum(Set, Sum, Subset) :- 
    subset(Set, Subset), sumlist(Subset, Sum).

sumlist([], 0).
sumlist([H | T], Sum) :-
    sumlist(T, CurrSum),
    Sum is CurrSum + H.

subset([], []).
subset([E|Tail], [E|NTail]) :-
    subset(Tail, NTail).
subset([_|Tail], NTail) :-
    subset(Tail, NTail).

shift([H|T], L2) :-
  append(T, [H], L2).

palindrome(List):-
    reverselist(List, RevList), compare(List, RevList).

reverselist([], []).
reverselist([X|Tail], List):-
    reverselist(Tail, Rev),
    append(Rev, [X], List).

compare([], []).
compare([X|T1], [X|T2]):-
    compare(T1, T2).

flatten([], []) :- !.
flatten([H|T], FlatList) :-
    flatten(H, NewH),
    flatten(T, NewT),
    append(NewH, NewT, FlatList),
    !.
flatten(L, [L]).

expression(X+Y) :- expression(X), expression(Y).
expression(X-Y) :- expression(X), expression(Y).
expression(X*Y) :- expression(X), expression(Y).
expression(X/Y) :- expression(X), expression(Y).
expression(X) :- atom(X).

btree(X) :- node(X).

node((X)) :- label(X).	
node((X,Y)) :- label(X), btree(Y).
node((X,Y,Z)) :- label(X), btree(Y), btree(Z).

label(X) :- atom(X) ; number(X).

leaves([[], L, []], [L]).
leaves([L,_,R], L) :- 
    leaves(L, Res1), 
    leaves(R, Res2), 
    append(Res1, Res2, L).

height([[], _, []], 1).
height([L,_,R], Res) :- 
    height(L, Res1), 
    height(R, Res2), 
    max(Res1, Res2, Res3), 
    Res is Res3 + 1.

max(X, Y, X) :- X >= Y, !.
max(X, Y, Y) :- Y > X.






