import groovy.swing.SwingBuilder

swing = new SwingBuilder()
frame = swing.frame(title: 'Migration') {
    panel {
        label 'Choose the step'
        comboBox(items: ['one', 'two', 'three'])
        button(label: 'Execute', actionPerformed: { event ->
            println event.source.text
            // any further processing is called here
            System.exit(0)
        })
    }
}
frame.pack()
frame.show()