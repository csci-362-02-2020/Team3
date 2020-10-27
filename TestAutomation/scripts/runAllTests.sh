#!/bin/bash

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
dir=$PWD
echo $PWD

# clean any existing testCaseExecutables
rm -f ..$dir/*.class

# compile all test case executables
javac  $dir/*.java
# echo "All test executables have been compiled"

# create array to read text case files
# declare -a array


function run_tests() {
    for file in ../testCases/*.txt 
    do
        echo \<tr\>
        while read line || [ -n "$line" ];
        do
            array+=("$line")
            echo \<td\>$line\<\/td\>
        done < "$file"
        
        declare testID=${array[0]}
        declare class=${array[1]}
        declare requirements=${array[2]}
        declare method=${array[3]}
        declare summary=${array[4]}
        declare inputs=${array[5]}
        declare expected_outputs=${array[6]}
        declare driver_name=${array[7]}
        declare result

        if [[$method == "containsOnlyDigitsDriver"]]
        then
            result=$(java testCaseExecutables.containsOnlyDigitsDriver "$input")
        fi

        if [[$method == "containsUpperAndLowerCaseDriver"]]
        then
            result=$(java testCaseExecutables.containsUpperAndLowerCaseDriver "$input")
        fi

        if [[$method == "convertToIntegerDriver"]]
        then
            result=$(java testCaseExecutables.convertToIntegerDriver "$input")
        fi

        if [[$method == "DateUtilDriver"]]
        then
            result=$(java testCaseExecutables.DateUtilDriver "$input")
        fi

        if [[$method == "DrugsByNameDriver"]]
        then
            result=$(java testCaseExecutables.DrugsByNameDriver "$input")
        fi
        echo \<td\>$result\<\/td\>

        if [[$result == $expected]]
        then
            echo \<td\>"Passed"\<\/td\>
        else
            echo \<td\>"Failed"\<\/td\>
        fi

        echo \<\/tr\>

    done
}

# read_text_files

echo "Array items:"
for item in ${array[*]}
do
    printf " %s\n" $item
done

echo "Array size: ${#array[*]}"


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
                <th>Test ID</th>
                <th>Class Name</th>
                <th>Summary</th>
                <th>Method Type</th>
                <th>Inputs</th>
                <th>Expected Outputs</th>
                <th>Driver</th>
                <th>Results</th>
            </tr>
            $(run_tests)
        </table><br>
        <footer>$TIME_STAMP</footer>
	</body>
	</html>
_EOF_

open $FILENAME

rm -f ../reports/$FILENAME
rm -f ../testCases/$FILENAME