----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 01/22/2024 07:18:07 PM
-- Design Name: 
-- Module Name: FourBitFullAdder - Behavioral
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

entity FourBitFullAdder is
    Port ( A : in STD_LOGIC_VECTOR (4 downto 1);
         B : in STD_LOGIC_VECTOR (4 downto 1);
         Cin : in STD_LOGIC;
         Cout : out STD_LOGIC;
         S : out STD_LOGIC_VECTOR (4 downto 1));
end FourBitFullAdder;

architecture Behavioral of FourBitFullAdder is

    component OneBitFullAdder
        Port (A,B,Cin:in std_logic;
             S,Cout: out std_logic);
    end component;

    Signal C1, C2, C3: std_logic;

begin

    oneOBFA: OneBitFullAdder PORT MAP(A => A(1), B => B(1), Cin => Cin, Cout => C1, S => S(1));
    twoOBFA: OneBitFullAdder PORT MAP(A => A(2), B => B(2), Cin => C1, Cout => C2, S => S(2));
    threeOBFA: OneBitFullAdder PORT MAP(A => A(3), B => B(3), Cin => C2, Cout => C3, S => S(3));
    fourOBFA: OneBitFullAdder PORT MAP(A => A(4), B => B(4), Cin => C3, Cout => Cout, S => S(4));

end Behavioral;
