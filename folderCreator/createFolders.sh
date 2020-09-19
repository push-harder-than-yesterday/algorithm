#!bin/bash


if [ -f ./problems.txt ]; then
  echo "Start creating folder"
else
  echo "You must make problems.txt file first!!"
  exit 1
fi

param=$1
reg=${param//[0-9]/}

if [ $# -ge 2 -o $# -lt 1 ] || [ -n "$reg" ] ; then
  echo "The program can only use one(1) number type parameter!"
  echo "Usage: $0 [Week num you want to use]"
  echo "Example: $0 1"
  exit 1
fi

week_info="week$1"
reg_week="week[0-9]"
find_week=false
is_end=false
while IFS= read -r line || [ -n "$line" ];
do
  if $is_end ; then
    break
  fi

  if [ "$line" = "$week_info" ]; then
    find_week=true
    if [ ! -d ../$week_info ]; then
      mkdir ../$week_info
    fi
    continue
  fi

  if [ "$find_week" = true ] && [[ $line =~ $reg_week ]]; then
    is_end=true
    continue
  fi
  
  if [ "$find_week" = true ]; then
    folder_name=$(echo $line | tr ' ' '-')
    if [ ! -d ../$week_info/$folder_name ]; then
      mkdir ../$week_info/$folder_name
    fi
  fi
done < problems.txt

if $find_week ; then
  echo "Finish creating folder"
else
  echo "Not find week!"
  echo "You must add week and problems to problems.txt"
fi
