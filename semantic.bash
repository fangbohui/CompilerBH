set -e
cd "$(dirname "$0")"
export CCHK="java -classpath ./lib/antlr-4.6-complete.jar:./bin Main"
mkdir -p /home/fangbohui/IdeaProjects/compiler2017bh/src
cat > /home/fangbohui/IdeaProjects/compiler2017bh/src/test.txt   # save everything in stdin to program.txt
$CCHK