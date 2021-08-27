## Implementando POC com Elasticsearch

#### docker network create elastic

#### docker run -d --name es01 --net elastic -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.14.0

#### docker run -d --name kib01 --net elastic -p 5601:5601 -e "ELASTICSEARCH_HOSTS=http://es01:9200" docker.elastic.co/kibana/kibana:7.14.0