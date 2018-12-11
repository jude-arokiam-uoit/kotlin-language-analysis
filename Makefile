all:
	pandoc README.md -s -o report.pdf
clean:
	rm report.pdf
