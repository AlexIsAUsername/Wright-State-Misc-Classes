# -*- coding: utf-8 -*-
#HW 7 Alex Yeoh

#%% Library Dependencies
from sympy import symbols, linsolve

#18
print(18)
va, vb = symbols('va vb')
variables = [va, vb]
solns, = linsolve([va/8+(va-vb)/2+((va-30)-vb)/2+(va-30)/4, -15+(vb-va)/2+(vb+(va-30))/2], (va,vb))
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))

#20
print(20)
va, i = symbols('va i')
variables = [va, i]
solns, = linsolve([(va-12)/4+va/4+(va-2*i)/1, (va-12)/4-i], (va,i))
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))

#41
print(41)
va, vb = symbols('va vb')
variables = [va, vb]
solns, = linsolve([va/4+(va-vb)/2+(va-(vb-6))/10, (vb-8)/1+(vb-va)/2+(vb-6)/5+((vb-6)-va)/10], (va,vb))
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))

#44
print(44)
va, vb = symbols('va vb')
variables = [va, vb]
solns, = linsolve([va/1+(va-(vb+180))/4-45, vb/5+45+((vb+180)+90)/2+((vb+180)-va)/4], (va,vb))
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))

#55
print(55)
va, vb = symbols('va vb')
variables = [va, vb]
solns, = linsolve([1+(va-vb)/2+(va+10)/6-4, vb/4+(vb-va)/2+(vb+8)/12+4], (va,vb))
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))

#72
print(72)
va = symbols('va')
variables = [va]
solns, = linsolve([(va+8)/5+va/2+(va-4)/4+((va+10)-4)/1+(va+10)/4], (va))
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))