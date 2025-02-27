import React from "react";

function UserDetails(props) {
  const details = props.details;

  return (
    <div>
      {details.includes("Aadhar") || details.includes("PAN") ? (
        <p>
          User is eligible for Government offers as they have{" "}
          {details.join(" and ")}.
        </p>
      ) : (
        <p>
          User is not eligible for Government offers as they have neither Aadhar
          nor PAN.
        </p>
      )}
    </div>
  );
}

export default UserDetails;
