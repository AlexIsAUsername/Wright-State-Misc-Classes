# -*- coding: utf-8 -*-
#HW 6 Alex Yeoh

#%% Library Dependencies
from sympy import symbols, linsolve
#Note: I didn't know this was something I needed to keep so I retyped all of this.

#2
print(2)
v1, v2 = symbols('v1 v2')
variables = [v1, v2]
solns, = linsolve([v1/10+v1/5+6+(v1-v2)/2, -6+(v2-v1)/2-3+v2/4], (v1,v2))
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))

#4
print(4)
va, vb = symbols('va vb')
variables = [va, vb]
solns, = linsolve([-6+va/20+va/10-3, 3+vb/40+vb/40-2], (va,vb))
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))

#6
print(6)
va, v1 = symbols('va v1')
variables = [va, v1]
solns, = linsolve([(va-10)/(10/3)+va/10+(va-20)/4, va/10-v1], (va,v1))
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))

#8
print(8)
va, vo = symbols('va vo')
variables = [va, vo]
solns, = linsolve([va/10+(va-60)/20+(va-5*vo)/20, va/10*4-vo], (va,vo))
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))
#I guess I mistyped somewhere in here the first time I did it.

#10
print(10)
va, vb, vc, io = symbols('va vb vc io')
variables = [va, vb, vc, io]
solns, = linsolve([va/8+4+(va-vc)/4, -4+vb/2+2*io, (vc-va)/1+-2*io+vc/4, va/8-io], (va,vb, vc, io))
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))

#12
print(12)
va, vb, vo, io = symbols('va vb vo io')
variables = [va, vb, vo, io]
solns, = linsolve([(va-40)/20+va/20+(va-vb)/10, (vb-va)/10+-4*io+vb/10, vb/10*10-vo, va/20-io], (va,vb, vo, io))
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))

#14
print(14)
va, vb, vo = symbols('va vb vo')
variables = [va, vb, vo]
solns, = linsolve([(va-100)/1+(va-vb)/2+12.5, -12.5+(vb-va)/2+vb/4+(vb+50)/8, vb/4*4-vo], (va,vb, vo))
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))

#22
print(22)
v1, v2, v0 = symbols('v1 v2 v0')
variables = [v1, v2, v0]
solns, = linsolve([(v1-12)/2+v1/4+3+(v1-v2)/8, (v2+5*v0)/1+-3+(v2-v1)/8, (v1-12)/2*2-v0], (v1, v2, v0))
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))
#I guess I mistyped somewhere in here the first time I did it.

#24
print(24)
va, vb, vc, vd, vo = symbols('va vb vc vd vo')
variables = [va, vb, vc, vd, vo]
solns, = linsolve([va/1+-4+(va-vd)/8, 4+vb/2+(vb-vc)/4, (vc-vb)/4+vc/2+2, -2+vd/1+(vd-va)/8, (va-vd)/8*8-vo], (va,vb, vc, vd, vo))
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))

#26
print(26)
v1, v2, v3, i0 = symbols('v1 v2 v3 i0')
variables = [v1, v2, v3, i0]
solns, = linsolve([(v1-15)/20+(v1-v2)/5+(v1-v3)/10+3, (v2-v1)/5+(v2-v3)/5+(v2-4*i0)/5, (v3+10)/15+(v3-v2)/5+(v3-v1)/10-3, (v1-v3)/10-i0], (v1, v2, v3, i0))
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))

#28
print(28)
a, b, c, d = symbols('a b c d')
variables = [a, b, c, d]
solns, = linsolve([((a-60)-d)/4+a/16+((a+90)-b)/8, (b-(a+90))/8+b/8+(b-c)/4, (c-b)/4+c/5+(c-d)/10, (d-c)/10+d/20+(d-(a-60))/4], (a, b, c, d))
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))

#30
print(30)
va, vb, vo, io = symbols('va vb vo io')
variables = [va, vb, vo, io]
solns, = linsolve([(va-80)/10+(va-4*vo)/20+(va-(vb-96))/40, ((vb-96)-va)/40+vb/80+-2*io, vb/80*80-vo, (va-(vb-96))/40-io], (va,vb, vo, io))
for i, var in enumerate(variables):
   print('{} = {}'.format(var, solns[i]))
