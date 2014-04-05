.PHONY: all compile clean
all: compile
	
compile:clean
	@mkdir -p bin
	@cd src; \
	javac -d ../bin  ./*.java
	@cd bin; jar -cfm ../cs296JTalk.jar ../manifest jtalkG10.class cs296JTalk/
clean:
	@rm -rf *.jar
	@rm -rf bin
