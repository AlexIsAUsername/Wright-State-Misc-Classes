----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 01/18/2024 07:49:23 PM
-- Design Name: 
-- Module Name: OneBitFullAdderTestbench - Behavioral
-- Project Name: 
-- Target Devices: 
-- Tool Versions: 
-- Description: 
-- 
-- Dependencies: 
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
-- 
----------------------------------------------------------------------------------


library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity OneBitFullAdderTestbench is
    --  Port ( );
end OneBitFullAdderTestbench;

architecture Behavioral of OneBitFullAdderTestbench is

    Component OneBitFullAdder is
        Port (A,B,Cin:in std_logic;
             S,Cout: out std_logic);
    End component;
    --inputs
    Signal a: std_logic:= '0';
    Signal b: std_logic:= '0';
    Signal cin: std_logic:= '0';
    --outputs
    Signal s: std_logic;
    Signal cout: std_logic;
    Constant period: time := 1ns;

begin

    Uut: OneBitFullAdder PORT MAP (a =>A, b => B, cin => Cin, s => S, cout => Cout);
    a<= not a after period;
    b<= not b after period*2;
    cin<= not cin after period*4;

end Behavioral;
