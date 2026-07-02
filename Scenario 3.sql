DECLARE
    CURSOR upcoming_loans_cur IS
        SELECT c.first_name, c.last_name, l.loan_id, l.due_date
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND (SYSDATE + 30);
BEGIN    
    FOR rec IN upcoming_loans_cur LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear ' || rec.first_name || ' ' || rec.last_name || 
            ', your loan (ID: ' || rec.loan_id || ') is due on ' || 
            TO_CHAR(rec.due_date, 'YYYY-MM-DD') || '.'
        );
    END LOOP;
END;
/