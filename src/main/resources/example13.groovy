import groovy.swing.SwingBuilder

swing = new SwingBuilder()
step1 = null
frame = swing.frame(title: 'Migration') {
    vbox {
        panel {
            boxLayout()
            step1 = checkBox(name: 'step1')
            label 'Step 1'
        }
        panel {
            boxLayout()
            checkBox(name: 'step2')
            label 'Step 2'
        }
        panel {
            button(label: 'Execute', actionPerformed: { event ->
                println event.source.text
                // any further processing is called here
                if (step1.selected) {
                    println 'funciona'
                    System.exit(0)
                }


            })
        }
    }

}
frame.pack()
frame.show()