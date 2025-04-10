#!/bin/bash

RESOURCE_GROUP="air_quality"
CLUSTER_NAME="air_quality_cluster"

KUBECTL_VERSION="1.32.1"

echo "Checking if AKS cluster '$CLUSTER_NAME' exists in resource group '$RESOURCE_GROUP'..."
SHOW_CLUSTER=$(az aks show --resource-group "$RESOURCE_GROUP" --name "$CLUSTER_NAME")

if [[ -z "$SHOW_CLUSTER" ]]; then
    echo "Creating Azure Kubernetes Service (AKS) cluster '$CLUSTER_NAME' in resource group '$RESOURCE_GROUP'..."
    az aks create --resource-group "$RESOURCE_GROUP" --name "$CLUSTER_NAME" --node-count 1 --generate-ssh-keys
fi

echo "Getting AKS cluster credentials..."
az aks get-credentials --resource-group "$RESOURCE_GROUP" --name "$CLUSTER_NAME" --overwrite-existing

echo "Installing kubectl..."
if ! command -v kubectl &>/dev/null; then
    az aks install-cli --client-version "$KUBECTL_VERSION"
fi

echo "Applying Kubernetes manifests..."
kubectl apply -f k8s/ --recursive