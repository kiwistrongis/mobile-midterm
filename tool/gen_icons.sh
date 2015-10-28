#!/bin/bash

source="img/icon.png"
sizes="48 72 96 144"
#sizes="16 24 32 64 512 1024"

for size in $sizes; do
	sizestr="${size}x${size}"
	target="gen/icon_${sizestr}.png"
	echo "starting $target..."
	gm convert $source \
		-resize ${sizestr} \
		$target
	echo "done $target"
done
