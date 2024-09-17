n = 20;

pascal = zeros(n, 2*n-1);

for i = 1:n
    for j = n-i+1:2:n+i-1
        if j == n-i+1 | j == n+i-1 then
            pascal(i,j) = 1;
        else
            pascal(i,j) = pascal(i-1,j-1) + pascal(i-1,j+1);
        end
    end
end

for i = 1:n
    for j = 1:2*n-1
        if pascal(i,j) <> 0 then
            printf('%4d', pascal(i,j));
        else
            printf('    ');
        end
    end
    printf('\n');
end
