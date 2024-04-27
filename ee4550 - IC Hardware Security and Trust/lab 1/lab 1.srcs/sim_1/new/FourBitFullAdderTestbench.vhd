----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 01/22/2024 07:31:19 PM
-- Design Name: 
-- Module Name: FourBitFullAdderTestbench - Behavioral
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

entity FourBitFullAdderTestbench is
    --  Port ( );
end FourBitFullAdderTestbench;

architecture Behavioral of FourBitFullAdderTestbench is

    Component FourBitFullAdder is
        Port (A, B: in std_logic_vector (4 downto 1);
             Cin:in std_logic;
             S: out std_logic_vector (4 downto 1);
             Cout: out std_logic);
    End component;

    --inputs
    Signal a: std_logic_vector (4 downto 1):= (others =>'0');
    Signal b: std_logic_vector (4 downto 1):= (others =>'0');
    Signal cin: std_logic:= '0';
    --outputs
    Signal s: std_logic_vector (4 downto 1);
    Signal cout: std_logic;
    Constant period: time := 1ns;

begin

    Uut: FourBitFullAdder PORT MAP (a => a, b => b, cin => cin, s => s, cout => cout);
    test:process
    begin
        a<="0110";
        b<="0011";
        cin<='0';
        wait for period;

        a<="1010";
        b<="0011";
        cin<='0';
        wait for period;

        a<="0100";
        b<="0101";
        cin<='1';
        wait for period;

        a<="0101";
        b<="0110";
        cin<='1';
        wait for period;

    end process;

end Behavioral;
