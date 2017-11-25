#docker build -t lakshithah1/peopleinfo .
#docker run -p 4910:3000 -d lakshithah1/peopleinfo


kubectl create -f deployments/peopleinfo.yaml

kubectl create -f services/peopleinfo.yaml
