#! /bin/bash

clear

echo "Starting Verification of Property COMPLETE_1 on FACPL Policy root"

#Alias z3 is assumed defined in the environment

z3 -st -smt2 Property_COMPLETE_1_root.smt2
