%% Module 10 Laplace Examples Fred Garber
sympref('FloatingPointOutput',true);
%% Example 9.11
clear all
% Declare symbolic variables
syms Vin v0 s t
% Nodal analysis directly in solve()
[v0]=solve((v0-Vin)/60 + v0*0.01*s + v0/(5*s)== 0)
% Transfer function
H(s) = v0/Vin
% Response to unit step
% Define unitstep for plotting
unitstep = @(t) +(t>0); 
clf
figure(911)
tmax = 4;
ymin = -5;
ymax = 5;
% The response to 3u(t)
v(t) = ilaplace(H(s)*3/s)
subplot(2,1,1)
fplot(@(t) 3*unitstep(t), [0,tmax])
hold on
fplot(v(t), [0,tmax]), grid
axis([0, tmax, ymin, ymax])
title('Response to 3*u(t)'); xlabel('t (seconds)'); ylabel('Volts')
% The response to a rectangular pulse: 3u(t) - 3u(t-2)
v(t) = ilaplace(H(s)*(3/s-3/s*exp(-2*s)))
subplot(2,1,2)
fplot(@(t) 3*unitstep(t) - 3*unitstep(t-2) , [0,tmax])
hold on
fplot(v(t), [0,tmax]), grid
axis([0, tmax, ymin, ymax])
title('Response to 3u(t) - 3u(t-2)'); xlabel('t (seconds)'); ylabel('Volts')
%
%%