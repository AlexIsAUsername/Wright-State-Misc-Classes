#%% Library Dependencies
from sympy import symbols, linsolve, simplify

#9.40
print(9.40)
# Define symbols
Vin, va, io, s = symbols('Vin va io s')
variables = [va,io]
# Enter node equations directly into linsolve with =0 implied
[va,io], = linsolve([(va-Vin)/s+va/2+va*0.05*s, (Vin-va)/s-io], (va, io))
H = simplify(io/Vin)
print('H = {}'.format(H))
print()

#9.44
print(9.44)
# Define symbols
Vin, va, i = symbols('Vin va i')
# Enter node equations directly into linsolve with =0 implied
[va, i], = linsolve([(va-Vin)/5+va/4+va/(10e-3*s)+va/(1/(5*10**-3*s)+3), (Vin-va)/5-i], (va, i))
H = simplify(i/Vin)
print('H = {}'.format(H))
print()

#9.46
print(9.46)
# Define symbols
Iin, va, io = symbols('Iin va io')
# Enter node equations directly into linsolve with =0 implied
[va, io], = linsolve([va/4+va/(0.2*s)-Iin+va/(3+(1/0.1*s)), va/(3+(1/0.1*s))-io], (va, io))
H = simplify(io/Iin)
print('H = {}'.format(H))
print()

#9.48
print(9.48)
# Define symbols
Vin, va, ix = symbols('Vin va ix')
# Enter node equations directly into linsolve with =0 implied
[va, ix], = linsolve([(va-Vin)/10+va/(0.2*s)+va/(30+1/(0.5*10**-3*s)), va/(30+1/(0.5*10**-3*s))-ix], (va, ix))
H = simplify(ix/Vin)
print('H = {}'.format(H))
print()

#10.1
print(10.1)
# Define symbols
Vin, va, i = symbols('Vin va i')
# Enter node equations directly into linsolve with =0 implied
[va, i], = linsolve([(va-Vin)+va*s+va/s+va, Vin-va-i], (va, i))
H = simplify(i/Vin)
print('H = {}'.format(H))
print()

#10.4
print(10.4)
# Define symbols
Vin, va, ix, vo = symbols('Vin va ix vo')
# Enter node equations directly into linsolve with =0 implied
[va, ix, vo], = linsolve([(va-Vin)/s-0.5*ix+va/(1/(0.25*s)+1), (Vin-va)/s-ix, va/(1/(0.25*s)+1)-vo], (va, ix, vo))
H = simplify(ix/Vin)
print('H = {}'.format(H))
H = simplify(vo/Vin)
print('H = {}'.format(H))
print()

#10.5
print(10.5)
# Define symbols
Vin, va, io = symbols('Vin va io')
# Enter node equations directly into linsolve with =0 implied
[va, io], = linsolve([(va-Vin)/2000+va/(0.25*s)+(va-10*io)*2*10**-6*s, (Vin-va)/2000-io], (va, io))
H = simplify(io/Vin)
print('H = {}'.format(H))
print()

#10.8
print(10.8)
# Define symbols
Iin, va, vb, io, vo = symbols('Iin va vb io vo')
# Enter node equations directly into linsolve with =0 implied
[va, vb, io, vo], = linsolve([-Iin+va/20+va*(50e-6)*s+(va-vb)/40-0.1*vo, 
                              0.1*vo+(vb-va)/40+vb/(100*10**-3*s), 
                              (va-vb)/40-io, va-vo], (va, vb, io, vo))
H = simplify(io/Iin)
print('H = {}'.format(H))
H = simplify(vo/Iin)
print('H = {}'.format(H))
print()

#10.9
print(10.9)
# Define symbols
Vin, va, vb, io, vo = symbols('Vin va vb io vo')
# Enter node equations directly into linsolve with =0 implied
[va, vb, io, vo], = linsolve([(va-Vin)/20+va/20+(va-vb)*(50*10**-6)*s,
                              (vb-va)*(50*10**-6)*s+4*io+vb/(10*10**-3*s+30),
                              va/20-io, vb/(10*10**-3*s+30)-vo], (va, vb, io, vo))
H = simplify(io/Vin)
print('H = {}'.format(H))
H = simplify(vo/Vin)
print('H = {}'.format(H))
print()

#10.10
print(10.10)
# Define symbols
Iin, va, vo, vx = symbols('Iin va vo vx')
# Enter node equations directly into linsolve with =0 implied
[va, vo, vx], = linsolve([-Iin+va/2000+va/(50*10**-3*s)+(va-vo)*2*10**-6*s, 
                          0.1*vx+vo/4000+(vo-va)*2*10**-6*s, va/(50*10**-3*s)-vx], (va, vo, vx))
H = simplify(vo/Iin)
print('H = {}'.format(H))
H = simplify(vx/Iin)
print('H = {}'.format(H))