FROM ubuntu:latest
LABEL authors="ghost"

ENTRYPOINT ["top", "-b"]