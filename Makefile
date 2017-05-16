# Makefile
# Nicholas Ho
# nidho
# pa4
# A simple Makefile for the Roots program
GCD: Roots.class
	echo Main-class: Roots > Manifest
	jar cvfm Roots Manifest Roots.class
	rm Manifest
	chmod u+x Roots

GCD.class: Roots.java
	javac -Xlint Roots.java

clean:
	rm -f Roots.class Roots

submit: Makefile Roots.java
	submit cmps011-pt.w15 pa4 Makefile Roots.java

check: 
	ls /afs/cats.ucsc.edu/class/cmps011-pt.w15/pa4/nidho
