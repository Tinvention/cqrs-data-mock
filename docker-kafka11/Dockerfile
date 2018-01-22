FROM inovatrend/java8

ADD start*.sh /kafka_2.11-0.11.0.2/

#ENV ADVERTISED_HOST=172.17.0.1

RUN curl -O http://mirror.nohup.it/apache/kafka/0.11.0.2/kafka_2.11-0.11.0.2.tgz && \
    tar xvzf kafka_2.11-0.11.0.2.tgz && \
    chmod +x /kafka_2.11-0.11.0.2/start*.sh && \
    mv /kafka_2.11-0.11.0.2/config/server.properties /kafka_2.11-0.11.0.2/config/server.properties.bak 

COPY server.properties /kafka_2.11-0.11.0.2/config/server.properties

EXPOSE 2181
EXPOSE 9092

WORKDIR /kafka_2.11-0.11.0.2/

CMD /kafka_2.11-0.11.0.2/start.sh ${ADVERTISED_HOST}
