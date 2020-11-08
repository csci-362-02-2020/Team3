#!/bin/bash
clear

# for debugging purposes
# exec 5> command.txt
# BASH_XTRACEFD="5"

echo "----------Running test script----------"

# Constants
TITLE="Team 3 | Carrillo, Krawczyk, Suzara"
RIGHT_NOW="$(date +"%x %r %Z")"
TIME_STAMP="Updated on $RIGHT_NOW by $USER"
FILENAME="testResults.html"
PACKAGE="testCaseExecutables"

# Create the HTML file
# touch reports/$FILENAME
> reports/$FILENAME

# cd to testCaseExecutables
cd testCasesExecutables

# compile all test case executables
mkdir testCaseExecutables
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
        while read line || [[ -n "$line" ]];
        do
            echo \<td\>$line\<\/td\>
            array[$i]="$line"
            i=$((i+1))
        done < $file

            # testID=${array[0]}
            # class=${array[1]}
            # requirements=${array[2]}
            # method=${array[3]}
            input=${array[4]}
            expected_output=${array[5]}
            driver_name=${array[6]}

            result=$(java $PACKAGE.$driver_name "$input")

            echo \<td\>$result\<\/td\>
            if [[ $result==$expected_output ]]; then
            
                echo \<td\>"Pass"\<\/td\>
            else
                echo \<td\>"Fail"\<\/td\>
            fi
        echo \</tr\>
        <&-
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

xdg-open $FILENAME

# clean any previous files and directories
rm -f testCaseExecutables/*.class
rm -d testCaseExecutables
rm -f $FILENAME
rm -f /reports/$FILENAME
rm -f /testCases/$FILENAME
