# Theme based on Bira theme from on-my-zsh

function current_path
	set_color --bold blue 
	echo -n (pwd)
	set_color normal
end

function git_branch_name
	echo (command git symbolic-ref HEAD ^ /dev/null | sed -e 's|^refs/heads/||')
	end

		
function git_is_dirty
	echo (command git status -s --ignore-submodules=dirty ^/dev/null)
end

function git_status
	if [ (git_branch_name) ]
		set -l git_branch (git_branch_name)

		if [ (git_is_dirty) ]
			set git_info '<'$git_branch"*"'>'
		else
			set git_info '<'$git_branch'>'
		end

		echo -n (set_color yellow) $git_info (set_color normal)

	end
end
	
function fish_prompt.fish
	echo -n (set_color white) "╭─" (set_color normal)
	current_path
	git_status
	echo -e ' '
	echo (set_color white)"╰─"(set_color --bold white)"\$ "(set_color normal)
end
