JC = javac
JFLAGS = -g
SOURCES = ToDoList.java test.java
CLASSDIR = bin
CLASSES = $(SOURCES:.java=.class)

all: $(CLASSES)

%.class: %.java
	@mkdir -p $(CLASSDIR)
	$(JC) $(JFLAGS) -d $(CLASSDIR) $<

clean:
	rm -rf $(CLASSDIR)

fclean: clean

.PHONY: all clean fclean
