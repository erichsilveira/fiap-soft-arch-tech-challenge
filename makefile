k apply -f postgres-service.yaml,postgres-deployment.yaml,postgres-data-persistentvolumeclaim.yaml
k apply -f food-service-backend-service.yaml,food-service-backend-deployment.yaml,food-service-backend-autosacling.yaml

k get hpa
k get pods

k delete pod,svc --all
k delete --all deployments --namespace=default
