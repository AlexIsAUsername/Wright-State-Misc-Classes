----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 01/23/2024 06:58:42 PM
-- Design Name: 
-- Module Name: FourBitAddSubTestbench - Behavioral
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

entity FourBitAddSubTestbench is
    --  Port ( );
end FourBitAddSubTestbench;

architecture Behavioral of FourBitAddSubTestbench is

    Component FourBitAddSub is
        Port (A, B: in std_logic_vector (4 downto 1);
             m:in std_logic;
             S: out std_logic_vector (4 downto 1);
             Cout: out std_logic);
    End component;

    --inputs
    Signal a: std_logic_vector (4 downto 1):= (others =>'0');
    Signal b: std_logic_vector (4 downto 1):= (others =>'0');
    Signal m: std_logic:= '0';
    --outputs
    Signal s: std_logic_vector (4 downto 1);
    Signal cout: std_logic;
    Constant period: time := 1ns;

begin

    Uut: FourBitAddSub PORT MAP (a => a, b => b, m => m, s => s, cout => cout);
    test:process
    begin
        a<="0110";
        b<="0011";
        m<='0';
        wait for period;

        a<="1010";
        b<="0011";
        m<='0';
        wait for period;

        a<="0100";
        b<="0101";
        m<='1';
        wait for period;

        a<="0101";
        b<="0110";
        m<='1';
        wait for period;

    end process;

end Behavioral;
