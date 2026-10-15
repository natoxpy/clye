all:
	@echo "> Building"
	@./gradlew installDist
	@echo "> Running"
	@./app/build/install/app/bin/app

test:
	@echo "> Testing"
	@./gradlew test
