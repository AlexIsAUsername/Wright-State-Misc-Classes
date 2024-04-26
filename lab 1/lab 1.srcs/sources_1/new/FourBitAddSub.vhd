----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 01/23/2024 06:51:32 PM
-- Design Name: 
-- Module Name: FourBitAddSub - Behavioral
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

entity FourBitAddSub is
    Port ( a : in STD_LOGIC_VECTOR (4 downto 1);
         b : in STD_LOGIC_VECTOR (4 downto 1);
         m : in STD_LOGIC;
         s : out STD_LOGIC_VECTOR (4 downto 1);
         cout : out STD_LOGIC);
end FourBitAddSub;

architecture Behavioral of FourBitAddSub is

    component FourBitFullAdder
        Port ( A : in STD_LOGIC_VECTOR (4 downto 1);
             B : in STD_LOGIC_VECTOR (4 downto 1);
             Cin : in STD_LOGIC;
             Cout : out STD_LOGIC;
             S : out STD_LOGIC_VECTOR (4 downto 1));
    end component;

    component XOR2
        Port ( A : in STD_LOGIC;
             B : in STD_LOGIC;
             C : out STD_LOGIC);
    end component;

    signal xorOut : STD_LOGIC_VECTOR (4 downto 1);

begin

    xo1: XOR2 PORT MAP(a => b(1), b => m, c => xorout(1));
    xo2: XOR2 PORT MAP(a => b(2), b => m, c => xorout(2));
    xo3: XOR2 PORT MAP(a => b(3), b => m, c => xorout(3));
    xo4: XOR2 PORT MAP(a => b(4), b => m, c => xorout(4));

    fulladder: FourBitFullAdder PORT MAP(A => A, B(1) => xorout(1), B(2) => xorout(2), B(3) => xorout(3), B(4) => xorout(4), Cin => m, Cout => cout, S => S);

end Behavioral;
