# -*- coding: utf-8 -*-
#%% Library Dependencies
#Change python thingy to conda version (to the right of Python on the bottom)
from sympy import symbols, linsolve

# Define symbols
va, vb, vc, vd, io = symbols('va vb vc vd io')
# Put vars into a list for easy manipulation
variables = [va, vb, vc, vd, io]
# Enter node equations directly into linsolve with =0 implied
solns, = linsolve(["va's nodes = 0", "vb's nodes = 0", "vc's nodes = 0", "vd's nodes = 0"], (va, vb, vc, vd, io)) #io equation left out since it's unused
# Print solutions
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))

# Define symbols
v1, v2, i6, v30= symbols('v1 v2 i6 v30')
variables = [v1, v2, i6, v30]
# Enter node equations directly into linsolve with =0 implied
solns, = linsolve(["equations with symbolic representations for voltage and current sources"], (v1,v2, i6, v30))
# Print solutions
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))
print('And for the specific numerical source inputs, we have:')   
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns.subs({i6:6, v30:30})[i]))