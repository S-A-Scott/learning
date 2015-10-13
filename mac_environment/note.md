# Terminal

## iTerm2
1. Install [iterm2](https://www.iterm2.com)
2. Set the iTerm2 color settings
   - [spencerized theme](https:/)
3. Install a patched font
   - [Meslo](https://github.com/Lokaltog/powerline-fonts/blob/master/Meslo/Meslo%20LG%20M%20DZ%20Regular%20for%20Powerline.otf). Click "view raw" to download the font
4. Set the Regular Font as Monaco in 14pt, Non-ASCII Font as Meslo in 14pt

## fish shell
1. Simply key in `brew install fish`

## Oh my fish
1. Install omf
   - `curl -L github.com/oh-my-fish/oh-my-fish/raw/master/bin/install | fish`
2. Install theme
   - `omf theme agnoster`

# Text Editor

## Vim
1. `mv vimrc ~/.vimrc`

## Emacs
1. Install Emacs
   - `brew tap railwaycat/emacsmacport`
   - `brew install emacs-mac --with-spacemacs-icon`
   - `git clone https://github.com/syl20bnr/spacemacs ~/.emacs.d`
   - `mv spacemacs ~/.spacemacs`


# Chrome


# TeX

1. Install [MacTeX](https://tug.org/mactex)
2. In order to set `$PATH`, add the line below to the ~/.config/fish/config.fish
   - `set -gx PATH /Library/TeX/texbin $PATH`
