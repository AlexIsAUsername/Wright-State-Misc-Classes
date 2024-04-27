#%% Library Dependencies
from sympy import symbols, linsolve

print('\n',2)
# Define symbols
v1, v2, i6, i3= symbols('v1 v2 i6 i3')
variables = [v1, v2, i6, i3]
# Enter node equations directly into linsolve with =0 implied
solns, = linsolve([v1/10+v1/5+i6+(v1-v2)/2, 
                  (v2-v1)/2-i6+v2/4-i3], (v1,v2, i6, i3))
# Print solutions
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))
print('And for the specific numerical source inputs, we have:')   
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns.subs({i6:6, i3:3})[i]))


print('\n',6)
# Define symbols
va, v1, v10, v20 = symbols('va v1 v10 v20')
variables = [va, v1, v10, v20]
# Enter node equations directly into linsolve with =0 implied
solns, = linsolve([(va-v10)/(10/3)+va/10+(va-v20)/4, 
                  va-v1], (va, v1, v10, v20))
# Print solutions
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))
print('And for the specific numerical source inputs, we have:')   
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns.subs({v10:10, v20:20})[i]))


print('\n',8)
# Define symbols
va, vo, v60 = symbols('va vo v60')
variables = [va, vo, v60]
# Enter node equations directly into linsolve with =0 implied
solns, = linsolve([va/10+(va-v60)/20+(va-5*vo)/20, 
                  va/10*4-vo], (va, vo, v60))
# Print solutions
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))
print('And for the specific numerical source inputs, we have:')   
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns.subs({v60:60})[i]))
   

print('\n',12)
# Define symbols
va, vb, ix, vo, v40 = symbols('va vb ix vo v40')
variables = [va, vb, ix, vo, v40]
# Enter node equations directly into linsolve with =0 implied
solns, = linsolve([(va-v40)/20+va/20+(va-vb)/10, 
                  (vb-va)/10+-4*ix+vb/10, 
                  va/20-ix, 
                  vb/10*10-vo], (va, vb, ix, vo, v40))
# Print solutions
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))
print('And for the specific numerical source inputs, we have:')   
for i, var in enumerate(variables):
   print('{} = {}'.format(var, round(solns.subs({v40:40})[i])))


print('\n',22)
# Define symbols
v1, v2, v0, v12, i3 = symbols('v1 v2 v0 v12 i3')
variables = [v1, v2, v0, v12, i3]
# Enter node equations directly into linsolve with =0 implied
solns, = linsolve([(v1-v12)/2+v1/4+i3+(v1-v2)/8, 
                  -3+(v2-v1)/8+(v2+5*v0)/1, 
                  (v1-v12)/2*2-v0], (v1, v2, v0, v12, i3))
# Print solutions
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))
print('And for the specific numerical source inputs, we have:')   
for i, var in enumerate(variables):
   print('{} = {}'.format(var, round(solns.subs({v12:12, i3:3})[i])))


print('\n',30)
# Define symbols
va, vb, io, vo, v80, v96 = symbols('va vb io vo v80 v96')
variables = [va, vb, io, vo, v80, v96]
# Enter node equations directly into linsolve with =0 implied
solns, = linsolve([(va-v80)/10+(va-4*vo)/20+(va-(vb-v96))/40, 
                  -2*io+vb/80+((vb-v96)-va)/40, 
                  (va-(vb-v96))/40-io, 
                  vb/80*80-vo], (va, vb, io, vo, v80, v96))
# Print solutions
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))
print('And for the specific numerical source inputs, we have:')   
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns.subs({v80:80, v96:96})[i]))
