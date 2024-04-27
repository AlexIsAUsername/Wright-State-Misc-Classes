#!/bin/bash -f
# ****************************************************************************
# Vivado (TM) v2021.1 (64-bit)
#
# Filename    : elaborate.sh
# Simulator   : Xilinx Vivado Simulator
# Description : Script for elaborating the compiled design
#
# Generated by Vivado on Tue Jan 23 19:06:30 EST 2024
# SW Build 3247384 on Thu Jun 10 19:36:07 MDT 2021
#
# IP Build 3246043 on Fri Jun 11 00:30:35 MDT 2021
#
# usage: elaborate.sh
#
# ****************************************************************************
set -Eeuo pipefail
# elaborate design
echo "xelab -wto 00f561f2fa4b47308c8555a174d13eea --incr --debug typical --relax --mt 8 -L xil_defaultlib -L secureip --snapshot FourBitAddSubTestbench_behav xil_defaultlib.FourBitAddSubTestbench -log elaborate.log"
xelab -wto 00f561f2fa4b47308c8555a174d13eea --incr --debug typical --relax --mt 8 -L xil_defaultlib -L secureip --snapshot FourBitAddSubTestbench_behav xil_defaultlib.FourBitAddSubTestbench -log elaborate.log
