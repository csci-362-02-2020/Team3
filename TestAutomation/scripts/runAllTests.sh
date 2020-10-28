#!/bin/bash
clear

# for debugging purposes
# exec 5> command.txt
# BASH_XTRACEFD="5"

echo "----------Running test script----------"

# Constants
DIRECTORY=${PWD##*/}
TITLE="Team 3 | Carrillo, Krawczyk, Suzara"
RIGHT_NOW="$(date +"%x %r %Z")"
TIME_STAMP="Updated on $RIGHT_NOW by $USER"
FILENAME="testResults.html"
PACKAGE="testCasesExecutables"

# Create the HTML file
touch ../reports/$FILENAME
> ../reports/$FILENAME

# list contents of current directory
list_directory(){ printf '%s\n' *;}

# cd to testCaseExecutables
cd ../testCasesExecutables

# clean any previous files and directories
rm -f ../testCaseExecutables/*.class


# compile all test case executables
javac  -d . *.java
echo "All test executables have been compiled"

# create array to read text case files
declare -a array

# function to run tests and add results to HTML table
function run_tests() {
    for file in ../testCases/*.txt 
    do
        i=0;
        echo \<tr\>
        while read line || [ -n "$line" ];
        do
            echo \<td\>$line\<\/td\>
            array[$i]="$line"
            # echo $array[$i]
            i=$((i+1))
        done < $file

            # testID=${array[0]}
            # class=${array[1]}
            # requirements=${array[2]}
            # method=${array[3]}
            input=${array[4]}
            expected_output=${array[5]}
            driver_name=${array[6]}

        if [[ $driver_name == "containsOnlyDigitsDriver" ]]; then
            result=$(java testCaseExecutables.containsOnlyDigitsDriver "$input")
        fi

        if [[ "$driver_name" == "containsUpperAndLowerCaseDriver" ]]; then
            result="$(java testCaseExecutables.containsUpperAndLowerCaseDriver "$input")"
        fi

        if [[ "$driver_name" == "convertToIntegerDriver" ]]; then
            result="$(java testCaseExecutables.convertToIntegerDriver "$input")"
        fi

        if [[ "$driver_name" == "DateUtilDriver" ]]; then
            result="$(java testCaseExecutables.DateUtilDriver "$input")"
        fi

        if [[ $driver_name == "DrugsByNameDriver" ]]; then
            result=$(java testCaseExecutables.DrugsByNameDriver "$input")
        fi

            # set -x
            echo \<td\>$result\<\/td\>
            if [[ $result==$expected_output ]]; then
            
                echo \<td\>"Pass"\<\/td\>
            else
                echo \<td\>"Fail"\<\/td\>
            fi
            # set +x
        echo \</tr\>
    done
}


# EOF = heredoc which is a section of code that is treated like a separate file
cat > $FILENAME <<_EOF_
	<!DOCTYPE html>
	<html>

	<head>

	<title>Test Results</title>

	<style>
	.sansserif {
  		font-family: Arial, Helvetica, sans-serif;
  	}
	body {
		background-color: #FFF;
        font-family: sans-serif;
	}

	div {
		padding-left: 25px;
		padding-right: 0px;
	}

	footer {
		color: #1F1B24;
		margin-left;
		font-size: 12px;
	}

    h1 {
		color: #1F1B24;
	}

    h2 {
        color: #1F1B24;
    }

    table {
        border-collapse: collapse;
		width: 100%;
    }

    td, th {
        border: 1px solid #ddd;
        text-align: left;
        padding: 8px;
    }

    tr:nth-child(even) {
        background-color: #ddd;
    }

	</style>
	</head>
	<body>
		<h1>$TITLE</h1>
        <h2>Test Results</h2>
        <table>
            <tr>
                <th>Test  ID</th>
                <th>Class Name</th>
                <th>Summary</th>
                <th>Method Type</th>
                <th>Inputs</th>
                <th>Expected Outputs</th>
                <th>Driver</th>
                <th>Results</th>
                <th>Pass/Fail</th>
            </tr>
            $(run_tests)
        </table><br>
        <footer>$TIME_STAMP</footer>
	</body>
	</html>
_EOF_

echo "----------Opening results in browser----------"

open $FILENAME

# rm -f ../reports/$FILENAME
rm -f ../testCases/$FILENAME