TARGET_DIR    = 'target'
CHAPTERS_DIR  = 'chapters'
ant           = new AntBuilder()

ant.delete(dir:TARGET_DIR)
ant.copy(todir:TARGET_DIR) {
    fileset(dir:CHAPTERS_DIR, includes:'*.doc', excludes:'~*')
}