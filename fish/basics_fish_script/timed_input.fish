#!/usr/bin/fish

set TIMELIMIT 3

function print_answer
	set -l timer_pid (jobs | sed -n '1p' | awk '{print $2}')
	kill $timer_pid
	echo $answer
end

function turn_on_timer
# TODO It seems no way to put the combined-commands into background in fish
#sleep $TIMELIMIT; and kill -s 14 (ps | sed -n '2p' | awk '{print $1}') $
	sleep $TIMELIMIT &
end

turn_on_timer
echo "1 + 2 equals to ?"
read answer
print_answer
