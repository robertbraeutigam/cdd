#! /bin/sh

for i in `find src/main/java/dev/robertbrautigam/cdd/backend/ -name "*java"`
do
   sed -i "s/public \(.*\)Response call/public WithMessages<\1Response> call/g" $i;
   sed -i "s/return response;/return WithMessages.of(response);/g" $i;
   sed -i "s/import dev.robertbrautigam.cdd.SystemException;/import dev.robertbrautigam.cdd.SystemException;\nimport dev.robertbrautigam.cdd.backend.WithMessages;/" $i
done
