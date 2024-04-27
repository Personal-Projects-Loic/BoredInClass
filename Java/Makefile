JC = javac
JFLAGS = -g
SOURCES = ToDoList.java miniBistro.java WeatherApp.java PierrePapierCiseaux.java
CLASSDIR = bin
CLASSES = $(SOURCES:.java=.class)

all: $(CLASSES)

%.class: %.java
	@mkdir -p $(CLASSDIR)
	$(JC) $(JFLAGS) -d $(CLASSDIR) $<

exec: all
	java $(CLASSDIR) WeatherApp

clean:
	rm -rf $(CLASSDIR)

fclean: clean

.PHONY: all clean fclean
